package test.scala

import scala.collection.mutable.LinkedList

class Unique_elementsTest extends org.scalatest.FunSuite
{
  test("test0")
  {
    val ob1=LinkedList('a')
    val ob2=LinkedList('b')
    ob1.next=ob2
    val symbol:Char='c'
    val list=main.scala.Unique_elements.AddNewElement(ob1,symbol)
    assert(list.elem == 'a')
    assert(list.next.elem == 'b')
    assert(list.next.next.elem == 'c')
    assert(list.next.next.next == Nil)
  }
  test("test1")
  {
    val obj=LinkedList[Char]()
    val symbol:Char='a'
    val list=main.scala.Unique_elements.AddNewElement(obj,symbol)
    assert(list.elem == 'a')
  }
  test("test2")
  {
    val ob1=LinkedList('a')
    val ob2=LinkedList('c')
    val ob3=LinkedList('a')
    val ob4=LinkedList('b')
    val ob5=LinkedList('b')
    ob1.next=ob2
    ob2.next=ob3
    ob3.next=ob4
    ob4.next=ob5
    val list=main.scala.Unique_elements.ReturnUniqueList(ob1)
    assert(list.elem == 'a')
    assert(list.next.elem == 'c')
    assert(list.next.next.elem == 'b')
    assert(list.next.next.next == Nil)
  }
  test("test3")
  {
    val ob1=LinkedList('a')
    val ob2=LinkedList('c')
    val ob3=LinkedList('a')
    val ob4=LinkedList('b')
    val ob5=LinkedList('b')
    ob1.next=ob2
    ob2.next=ob3
    ob3.next=ob4
    ob4.next=ob5
    val list=main.scala.Unique_elements.ReturnUniqueListRecF(ob1,ob1,ob1)
    assert(list.elem == 'a')
    assert(list.next.elem == 'c')
    assert(list.next.next.elem == 'b')
    assert(list.next.next.next == Nil)
  }
  test("test4")
  {
    val ob1=LinkedList('a')
    val ob2=LinkedList('a')
    val ob3=LinkedList('a')
    ob1.next=ob2
    ob2.next=ob3
    val list=main.scala.Unique_elements.ReturnUniqueList(ob1)
    assert(list.elem == 'a')
    assert(list.next == Nil)
  }
  test("test5")
  {
    val ob1=LinkedList('a')
    val ob2=LinkedList('a')
    val ob3=LinkedList('a')
    ob1.next=ob2
    ob2.next=ob3
    val list=main.scala.Unique_elements.ReturnUniqueListRecF(ob1,ob1,ob1)
    assert(list.elem == 'a')
    assert(list.next == Nil)
  }
}
