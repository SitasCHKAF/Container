public class List {

    private ListElement head;       // указатель на первый элемент
    private ListElement tail;       // указатель последний элемент

    void addFront(int data)           //добавить спереди
    {
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;              //инициализируем данные.
        // указатель на следующий элемент автоматически инициализируется как null
        if(head == null)            //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        }
        else {
            a.next = head;          //иначе новый элемент теперь ссылается на "бывший" первый
            head = a;               //а указатель на первый элемент теперь ссылается на новый элемент
        }
    }

    void addBack(int data) {          //добавление в конец списка
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;
        if (tail == null)           //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        } else {
            tail.next = a;          //иначе "старый" последний элемент теперь ссылается на новый
            tail = a;               //а в указатель на последний элемент записываем адрес нового элемента
        }
    }
    public void addAfter(int prevEl, int nextEl){//Мстод который задали вам
        ListElement t = this.head; //Получаем ссылку на первоэлемент
        while (t!=null){
            if(prevEl==t.data){
                ListElement e = new ListElement();
                e.data = nextEl;
                e.next = t.next;
                t.next = e;
                t =e;
            }
            t = t.next;
        }

    }
    void printList()                //печать списка
    {
        ListElement t = this.head;       //получаем ссылку на первый элемент
        while (t != null)           //пока элемент существуе
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next;                     //и переключаемся на следующий
        }
        System.out.println();
    }

    void delEl(int data)          //удаление элемента
    {
        if(head == null)        //если список пуст -
            return;             //ничего не делаем

        if (head == tail) {     //если список состоит из одного элемента
            head = null;        //очищаем указатели начала и конца
            tail = null;
            return;             //и выходим
        }

        if (head.data == data) {    //если первый элемент - тот, что нам нужен
            head = head.next;       //переключаем указатель начала на второй элемент
            return;                 //и выходим
        }

        ListElement t = head;       //иначе начинаем искать
        while (t.next != null) {    //пока следующий элемент существует
            if (t.next.data == data) {  //проверяем следующий элемент
                if(tail == t.next)      //если он последний
                {
                    tail = t;           //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next.next;   //найденный элемент выкидываем
                return;                 //и выходим
            }
            t = t.next;                //иначе ищем дальше
        }
    }
    boolean findEl(int data)
    {
        ListElement t = head; //ссылка на первый элемент
        if(t == null)     //если список пуст
            return false;
        if(head.data == data)   //если первый элемент - тот, что нам нужен
            return true;
        while(t.next != null) //пока следующий элемент существует
        {
            if (t.next.data == data) {  //проверяем следующий элемент
                return true;
            }
            t = t.next;   //переключаем указатель
        }
        return false;
    }
}
