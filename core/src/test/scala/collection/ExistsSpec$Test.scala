package collection

import org.scalatest.FunSuite

class ExistsSpec$Test extends FunSuite {

  test("check file in  the path") {
    val list = List("/", "/abc", "/assets/*")

    assert(ExistsSpec.checkExist(list, "/") === true)
    assert(ExistsSpec.checkExist(list, "/abc") === true)
    assert(ExistsSpec.checkExist(list, "/assets/abc") === true)
    assert(ExistsSpec.checkExist(list, "/foo") === false)
    assert(ExistsSpec.checkExist(list, "/abc/") === false)
    assert(ExistsSpec.checkExist(list, "assets/") === false)
    assert(ExistsSpec.checkExist(list, "/assets") === false)
  }

}
