public class Test {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","爆炸头");

        LinkedList list = new LinkedList();
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);
        list.listNode();


    }
}

class LinkedList{
    private HeroNode headNode = new HeroNode(0,"","");
    public void add(HeroNode heroNode){
        HeroNode temp = headNode;
        while(true){
            if (temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;

    }
    public void listNode(){
        if (headNode ==null){
            System.out.println("链表空");
            return;
        }
        HeroNode temp = headNode.next;
        while(true){
            if (temp ==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
class HeroNode{
    private int no;
    private String name;
    private String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
