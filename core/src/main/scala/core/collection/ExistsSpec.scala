package core.collection

object ExistsSpec {
  def checkExist(pathList: List[String], value: String) : Boolean = {
    pathList.exists(path => path == value || (path.last == '*' && value.startsWith(path.init)))
  }

}
