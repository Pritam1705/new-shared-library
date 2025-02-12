package org.p11combinedforce.terraformCD

def call(String Directory) {
    stage("Terraform plan") {
        script {
            sh """
                cd ${Directory}
                terraform plan
            """
        }
    }
}
