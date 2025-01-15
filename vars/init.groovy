import org.terraform.terraform_init

def call(def steps) {
    terraform_init.initTerraform(steps) // Correctly calls the static method
}
