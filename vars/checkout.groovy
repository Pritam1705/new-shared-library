import org.generic.Checkout
def checkout(String url, String creds, String branch) {
    new Checkout().call(url, creds, branch)
}
