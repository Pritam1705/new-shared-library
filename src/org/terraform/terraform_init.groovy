package org.terraform

class CloneRepo {
    static void cloneRepo(def steps) {
        steps.sh "terraform init"
    }
}
