package org.terraform

class terraform_init {
    static void terraform_init(def steps) {
        steps.sh "terraform init"
    }
}
