package org.p11combinedforce.terraformCD

def call(String Directory) {
    stage("Terraform validate") {
        script {
            sh """
                cd ${Directory}
                terraform validate
            """
        }
    }
}
