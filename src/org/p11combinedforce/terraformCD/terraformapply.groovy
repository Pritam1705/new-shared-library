package org.p11combinedforce.terraformCD

def call(String Directory) {
    stage("Terraform apply") {
        script {
            // Prompting user for confirmation before applying Terraform changes
            def userApproval = input(
                message: "Do you want to proceed with Terraform apply?",
                parameters: [
                    choice(name: "CONFIRM", choices: ["Yes", "No"], description: "Select 'Yes' to apply changes")
                ]
            )

            if (userApproval == "Yes") {
                sh """
                    cd ${Directory}
                    terraform apply 
                """
            } else {
                echo "Terraform apply was skipped by the user."
            }
        }
    }
}
