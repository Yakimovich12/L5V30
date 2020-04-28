import scala.collection.mutable.LinkedList;

object Unique_elements {
  def main(args:Array[String])
  {
    var list=LinkedList[Char]();
    var uniqueList=LinkedList[Char]();
    var clone=LinkedList[Char]();
    var code=1;
    while(code!=0)
    {
      println("Введите код опрерации");
      println("1-Добавить элемент в список");
      println("2-Получить список из уникальных элементов(не рекурсивная функция)");
      println("3-Получить список из уникальных элементов (рекурсивная функция)");
      println("4-Получить элементы оригинального списка")
      println("5-Получить уникальные элементы списка");
      println("0-Выход");
      code=readInt();
      if(code==1)
      {
        println("Введите символ в список");
        var symbol=readChar();
        list=AddNewElement(list,symbol);
      }
      if(code==2)
        uniqueList=ReturnUniqueList(list);
      if(code==3)
      {
        clone=CopyList(list);
        uniqueList=ReturnUniqueListRecF(clone,clone,clone);
      } 
      if(code==4)
        PrintList(list);
      if(code==5)
        PrintList(uniqueList);
    }
    
  }
  def AddNewElement(list:LinkedList[Char],symbol:Char):LinkedList[Char]=
  {
    
    var ob=LinkedList(symbol);
    if(list==Nil)
      ob;
    else
    {
      var cur=list;
      while(cur.next!=Nil)
        cur=cur.next;
      cur.next=ob;
      list
    }
  }
  
   def CopyList(list: LinkedList[Char]): LinkedList[Char] =
   {
     var clone=LinkedList[Char]();
     var cur=list;
     while(cur!=Nil)
     {
       clone=AddNewElement(clone,cur.elem);
       cur=cur.next;
     }
     clone;
   }
   
  def PrintList(list: LinkedList[Char]):Unit=
  {
    var cur=list
    if(cur==Nil)
      println("В списке нет элементов");
    else
      while(cur!=Nil)
    {
      println(cur.elem);
      cur=cur.next;
    }
  }
  
  def ReturnUniqueList(list:LinkedList[Char]):LinkedList[Char]=
  {
    var uniqueList=LinkedList[Char]();
    var flag=false; 
    var cur1=list;
    while(cur1!=Nil)
    {
      var cur2=uniqueList
        flag=false;
         while(cur2 != Nil)
         {
           if(cur2.elem.equals(cur1.elem))
           {
             flag=true;
           }
           //else
             cur2=cur2.next;  
         }
         if(!flag)
           uniqueList=AddNewElement(uniqueList,cur1.elem);
      cur1=cur1.next;
    }  
    uniqueList;
  }
  
  def ReturnUniqueListRecF(prevList:LinkedList[Char],curList:LinkedList[Char],list:LinkedList[Char]):LinkedList[Char]=
  {
    if(prevList!=Nil)
    {
      if(curList.next!=Nil)
      {
        if(curList.next.elem.equals(prevList.elem))
        {
          curList.next=curList.next.next;
          ReturnUniqueListRecF(prevList,curList,list);
        } 
        else
          ReturnUniqueListRecF(prevList,curList.next,list);
      }
      else
        ReturnUniqueListRecF(prevList.next,prevList.next,list);
    }
    else
      list;
  }
}