package com.shx.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","爆炸头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.addNode(hero1);
//        singleLinkedList.addNode(hero2);
//        singleLinkedList.addNode(hero3);
//        singleLinkedList.addNode(hero4);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);

        singleLinkedList.listNode();
        HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟~~~~~");
        singleLinkedList.updateNode(newHeroNode);

        System.out.println("修改后的链表");
        singleLinkedList.listNode();
        singleLinkedList.deleteNode(1);
        singleLinkedList.deleteNode(4);
        singleLinkedList.deleteNode(2);
        singleLinkedList.deleteNode(3);



        System.out.println("删除后的链表");
        singleLinkedList.listNode();



    }
}


class SingleLinkedList{
    // 头节点，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表
    public void addNode(HeroNode heroNode){

        HeroNode temp = head;
        while(true){
            if (temp.next==null){

                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;

    }

    // 第二种添加方式
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }else if(temp.next.no > heroNode.no){
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("编号%d已经存在\n",heroNode.no);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //修改节点的信息
    public void updateNode(HeroNode heroNode){
        if (head.next==null){
            System.out.println("链表空");
            return;

        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if (temp==null){
                break;
            }
            if (temp.no ==heroNode.no){
                flag =true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickname  = heroNode.nickname;
        }else{
            System.out.printf("没找到编号%d的节点\n",heroNode.no);
        }
    }

    //删除节点
    public void deleteNode(int no){
        if (head.next==null){
            System.out.println("链表为空");
            return;

        }
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no ==no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("没找到%d\n",no);
        }
    }



    public void listNode(){
        if (head.next == null){
            System.out.println("链表空");
            return;
        }
        HeroNode temp;
        temp = head.next;
        while(true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;


    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name  = name;
        this.nickname = nickname;

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
