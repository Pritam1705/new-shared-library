import org.terraform.terraform_init

def call(def steps, String dir = '.') { // Add `dir` parameter
    terraform_init.initTerraform(steps, dir)
}
