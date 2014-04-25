
def idValue(f: Int => Int, x: Int): Int = f(x)

type idType[A[_], B] = A[B]

idValue(x => x+ 1, 3)

def idTypeTry: idType =