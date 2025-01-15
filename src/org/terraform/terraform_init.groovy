package org.terraform

class terraform_init {
    static void initTerraform(def steps) {
        steps.sh "terraform init"
    }
}
