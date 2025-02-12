package org.p11combinedforce.terraformCD

def call(String Directory) {
    stage("Terraform apply") {
        script {
            // Debugging: Jenkins me current user ID print karo
            def currentUser = env.BUILD_USER_ID ?: 'unknown'
            echo "Current Jenkins User: ${currentUser}"

            // Admin users list
            def adminUsers = ["admin", "amit", "priyanshu"]

            def userApproval = input(
                message: "Do you want to proceed with Terraform destroy?",
                parameters: [
                    choice(name: "CONFIRM", choices: ["Yes", "No"], description: "Select 'Yes' to destroy resources")
                ]
            )

            if (userApproval == "Yes") {
                if (adminUsers.contains(currentUser)) {
                    echo "✅ User '${currentUser}' is authorized. Proceeding with destroy..."
                    sh """
                        cd ${Directory}
                        terraform destroy -auto-approve 
                    """
                } else {
                    error("🚨 Unauthorized! Only Admin Users can run Terraform Destroy. Current User: ${currentUser}")
                }
            } else {
                echo "Terraform destroy was skipped by the user."
            }
        }
    }
}
