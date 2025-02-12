package org.p11combinedforce.terraformCD

def call(String Directory) {
    stage("Terraform Fmt") {
        script {
            sh """
                cd ${Directory}
                terraform fmt
            """
        }
    }
}
