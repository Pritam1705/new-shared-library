package org.p11combinedforce.terraformCD

def call(String Directory) {
    stage("Terraform init") {
        script {
            sh """
                cd ${Directory}
                terraform init
            """
        }
    }
}
