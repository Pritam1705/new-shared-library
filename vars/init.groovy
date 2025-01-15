import org.terraform.terraform_init

def call() {
    new terraform_init().init(this)
}
