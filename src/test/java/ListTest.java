import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @org.junit.jupiter.api.Test
    void testAddFrontandFindEl() {
        List list = new List();
        list.addFront(1);
        list.addFront(2);
        assertTrue(list.findEl(1));
        assertTrue(list.findEl(2));
        assertFalse(list.findEl(3));
        }

    @org.junit.jupiter.api.Test
    void testAddAfter() {
        List list = new List();
        list.addFront(1);
        list.addFront(2);
        list.addAfter(2,3);
        list.printList();
        assertTrue(list.findEl(3));
    }

    @org.junit.jupiter.api.Test
    void testDelElANDaddBack() {
        List list =new List();
        list.addBack(2);
        list.addBack(3);
        list.addFront(1);
        list.delEl(3);
        list.delEl(1);
        list.delEl(2);
        assertFalse(list.findEl(1));
        assertFalse(list.findEl(2));
        assertFalse(list.findEl(3));
    }
}