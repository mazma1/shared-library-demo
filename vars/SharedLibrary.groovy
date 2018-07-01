class SharedLibrary implements Serializable {
  def steps
  def failedBuild
  def successfulBuild

  // constructor
  SharedLibrary(steps) {
    this.steps = steps
  }

  def setVars() {
    successfulBuild = "Your build was successful"
    failedBuild = "Oh snap, your build has failed"
  }

  def failedNotification() {
    steps.echo "${failedBuild}"
  }

  def successNotification() {
    echo "${successfulBuild}"
  }
}
