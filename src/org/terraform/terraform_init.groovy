package org.terraform

class terraform_init {
    static void initTerraform(def steps, String dir = '.') { // Default directory is '.'
        steps.sh """
        cd ${dir} 
        terraform init
        """
    }
}
