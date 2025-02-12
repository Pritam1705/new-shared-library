package org.p11combinedforce.terraformCD

def call(String Directory) {
    stage("Terraform apply") {
        script {
            def userApproval = input(
                message: "Do you want to proceed with Terraform destroy?",
                parameters: [
                    choice(name: "CONFIRM", choices: ["Yes", "No"], description: "Select 'Yes' to destroy resources")
                ]
            )

            
            def currentUser = env.BUILD_USER_ID ?: 'unknown'

            def adminUsers = ["pritam"] 

            if (userApproval == "Yes") {
                if (adminUsers.contains(currentUser)) {
                    sh """
                        cd ${Directory}
                        terraform destroy -auto-approve 
                    """
                } else {
                    error("Unauthorized! Only Admin Users can run Terraform Destroy.")
                }
            } else {
                echo "Terraform destroy was skipped by the user."
            }
        }
    }
}
