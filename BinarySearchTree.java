/**
 * Created by hamhochoi on 08/10/2016.
 */

import java.util.*;


class NumberNode {

    private int value;
    private NumberNode left;
    private NumberNode right;
    private NumberNode parent;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public NumberNode getLeft() {
        return left;
    }

    public void setLeft(NumberNode left) {
        this.left = left;
    }

    public NumberNode getRight() {
        return right;
    }

    public NumberNode getParent() {
        return parent;
    }

    public void setParent(NumberNode parent) {
        this.parent = parent;
    }

    public void setRight(NumberNode right) {
        this.right = right;
    }
}


class StringNode {

}


public class BinarySearchTree {

    // Khoi tao ROOT

    static NumberNode rootNumber = null;
    static StringNode rootString = new StringNode();







    // Tao mot NODE moi

    static NumberNode makeNode(int value) {

        NumberNode node = null;

        try {
            node = new NumberNode();
            node.setLeft(null);
            node.setRight(null);
            node.setParent(null);
            node.setValue(value);
        } catch (Exception e) {
            System.out.println("Out of memory!");
        }
        return node;

    }

    static StringNode makeNode(String string) {
        StringNode node = new StringNode();

        return node;
    }








    // Kiem tra mot NODE co phai la to tien cua mot NODE khac?

    static boolean isAncestor(NumberNode node1, NumberNode node2){      // kiem tra NODE 1 la ancestor cua NODE 2

        boolean boo = false;

        if (node1 == null || node2 == null){
            System.out.println("Node truyen vao khong duoc NULL");
            return false;
        }




        if (node1.getLeft().getValue() == node2.getValue() || node1.getRight().getValue() == node2.getValue()){
            return true;
        }

        if (node1.getLeft() == null && node1.getRight() == null){
            return false;
        }


        if (node1.getLeft() != null || node1.getRight() != null){
            if (node1.getLeft() != null) {
                boo = isAncestor(node1.getLeft(), node2);
            }
            else {
                boo = isAncestor(node1.getRight(), node2);
            }


        }




        return  boo;
    }









    //CASE 1:
    // Tao them mot NODE moi vao cay

    static NumberNode insertNode(NumberNode node, int value) {

        if (node == null){
            node = makeNode(value);
            return node;
        }

        NumberNode newNode;

        if (value <= node.getValue()) {
            if (node.getLeft() == null) {           // Neu la nut la thi dung lai va them nut
                newNode = makeNode(value);
                newNode.setParent(node);
                node.setLeft(newNode);
            } else {                                // Neu khong phai la nut la thi di sang con trai
                insertNode(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {          // Neu la nut la thi dung lai va them nut
                newNode = makeNode(value);
                newNode.setParent(node);
                node.setRight(newNode);
            } else {                                // Neu khong phai la nut la thi di sang con phai
                insertNode(node.getRight(),value);
            }
        }

        return node;                             // Tra lai vi tri cua nut moi them vao
    }

    static StringNode insertNode(StringNode node, String string) {

        NumberNode newNode = null;

        return node;
    }









    // CASE 2:
    // Tim kiem

    static NumberNode search(NumberNode node, int value) {

        NumberNode newNode=null;

        if (node == null){
            System.out.println("Cay khong ton tai!");
            return null;
        }

        if (node.getLeft() != null || node.getRight() != null){

            if (value == node.getValue()) {
                newNode = node;
            } else if (value < node.getValue()) {
                newNode = search(node.getLeft(), value);
            } else if (value > node.getValue()){
                newNode = search(node.getRight(), value);
            }
        }
        else {
            if (value != node.getValue()){
                return null;
            }
            else {
                newNode = node;
            }
        }

        return newNode;
    }


    static StringNode search(StringNode node, String value) {

        StringNode newNode = new StringNode();

        return newNode;
    }








    // CASE 3:
    // Tim MIN

    static NumberNode findMin(NumberNode node) {

        NumberNode newNode;
        if (node == null){
            return null;
        }

        if (node.getLeft() != null) {
            newNode = findMin(node.getLeft());
        } else {
            newNode = node;
        }

        return newNode;

    }

    static StringNode findMin(StringNode node) {
        StringNode newNode = new StringNode();

        return newNode;
    }








    // CASE 4:
    // Tim MAX

    static NumberNode findMax(NumberNode node) {

        NumberNode newNode;
        if (node == null){
            return null;
        }

        if (node.getRight() != null) {
            newNode = findMax(node.getRight());
        } else {
            newNode = node;
        }

        return newNode;

    }

    static StringNode findMax(StringNode node) {
        StringNode newNode = new StringNode();

        return newNode;
    }






    // CASE 5:
    // Predcessor : Ke can truoc (Dang co van de !!!)

    static NumberNode predcessor(NumberNode node, NumberNode x) {       // x la NODE can tim ke can truoc

        NumberNode newNode=x;

        if (x.getLeft() != null) {      // Neu khong co cay con trai thi x khong co ke can truoc
            return findMax(x.getLeft());
        }


        while (newNode.getParent() != null){
            if (x.getValue() >= newNode.getParent().getValue()){
                newNode = newNode.getParent();
                break;
            }

            newNode = newNode.getParent();
        }

        return newNode;
    }


    static StringNode predcessor(StringNode node, StringNode x) {

        StringNode newNode = new StringNode();


        return newNode;
    }









    // CASE 6:
    // Successor: ke can sau  (Dang co van de !!!)

    static NumberNode successor(NumberNode node, NumberNode x) {

        NumberNode newNode=x;

        if (x.getRight() != null){
            return  findMin(x.getRight());
        }

        while (newNode.getParent() != null){
            if (x.getValue() < newNode.getParent().getValue()){
                newNode = newNode.getParent();
                break;
            }

            newNode = newNode.getParent();
        }


        return newNode;

    }


    static StringNode successor(StringNode node, StringNode x) {

        StringNode newNode = new StringNode();


        return newNode;

    }









    // CASE 7:
    // Xoa NODE khoi cay dang co van de

    static void delNode(NumberNode node, int value) {
        NumberNode newNode;

        if (node == null){
            System.out.println("Khong co nut can xoa tren cay!");
            return ;
        }

        if (value == node.getValue()) {
            if (node.getLeft() == null && node.getRight() == null) {        // Nut can xoa la nut la
                if (node == rootNumber){
                    rootNumber = null;
                }
                else if (node.getParent().getRight() != null && node.getParent().getRight() == node){
                    node.getParent().setRight(null);
                }
                else {
                    node.getParent().setLeft(null);
                }
            } else if (node.getLeft() != null && node.getRight() == null) { // Nut can xoa chi co con trai
                if (node == rootNumber){                                             // Neu nut can xoa la nut goc
                    rootNumber = node.getLeft();
                }
                else if (node == node.getParent().getRight()) {                      // Neu nut can xoa la con phai cua nut cha
                    node.getParent().setRight(node.getLeft());
                    node.getLeft().setParent(node.getParent());
                } else {                                                        // nguoc lai, nut can xoa la con trai cua nut cha
                    node.getParent().setLeft(node.getLeft());
                }
            } else if (node.getLeft() == null && node.getRight() != null) { // Nut can xoa chi co con phai
                if (node == rootNumber){                                             // Neu nut can xoa la nut goc
                    rootNumber = node.getRight();
                }
                else if (node == node.getParent().getRight()) {                      // Neu nut can xoa la con phai cua nut cha
                    node.getParent().setRight(node.getLeft());
                    node.getRight().setParent(node.getParent());
                    node = null;
                } else {                                                        // nguoc lai, nut can xoa la con trai cua nut cha
                    node.getParent().setLeft(node.getLeft());
                }
            } else if (node.getLeft() != null && node.getRight() != null) { // Nut can xoa co day du 2 con trai, phai
                newNode = successor(rootNumber, node);

                //  Noi con phai cua successor vao cha cua successor
                //  Thay the sucessor vao NODE can xoa


                    // Dua con phai cua nut newNode vao con cua cha nut newNode

                if (newNode.getParent() != node){
                    newNode.getParent().setLeft(newNode.getRight());
                    if (newNode.getRight() != null){
                        newNode.getRight().setParent(newNode.getParent());
                    }
                }
                else {
                    newNode.getParent().setRight(newNode.getRight());
                    if (newNode.getRight() != null){
                        newNode.getRight().setParent(newNode.getParent());
                    }
                }

                node.setValue(newNode.getValue());

            }
        }
        else if (value < node.getValue()) {
            delNode(node.getLeft(), value);
        } else {
            delNode(node.getRight(), value);
        }

    }


    static StringNode delNode(StringNode node, String value) {

        StringNode sucessor = new StringNode();

        return sucessor;
    }









    // CASE 8:
    // In cay

    static void displayTree(NumberNode node){
        if (node == null){
            System.out.println("Cay khong ton tai");
            return;
        }

        if (node.getLeft() != null){
            displayTree(node.getLeft());
        }
        if (node.getRight() != null){
            displayTree(node.getRight());
        }

        System.out.println(node.getValue());
    }

    static void displayTree(String node){

    }


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Thuat toan cay nhi phan tim kiem");

        System.out.println("Ban muon tim kiem voi gia tri la so nguyen hay chuoi ?");
        System.out.println("Gia tri la so nguyen (Y/N)? ");
        String c = scan.next();

        if ("Y".equals(c) == true || "y".equals(c) == true) {            // lam viec voi so nguyen

            while (true) {
                System.out.println("Chon chuc nang :");
                System.out.println("1. Them mot Node moi vao cay");
                System.out.println("2. Tim kiem  ");
                System.out.println("3. Tim Node co khoa nho nhat");
                System.out.println("4. Tim Node co khoa lon nhat");
                System.out.println("5. Tim Node ke can truoc cua Node hien tai");
                System.out.println("6. Tim Node ke can sau cua Node hien tai");
                System.out.println("7. Xoa mot Node");
                System.out.println("8. In cay");
                System.out.println("9. Thoat chuong trinh");

                int n = scan.nextInt();
                NumberNode newNode=null;

                switch (n) {
                    case 1:
                        System.out.println("Nhap vao gia tri cua Node muon them: ");
                        int value = scan.nextInt();
                        rootNumber = insertNode(rootNumber, value);
                        System.out.println("Gia tri root la: " + (rootNumber.getValue()));
                        break;
                    case 2:
                        System.out.println("Nhap vao khoa tim kiem : ");
                        int key = scan.nextInt();
                        newNode = search(rootNumber, key);
                        if (newNode == null) {
                            System.out.println("Khong tim thay khoa tren cay!");
                        } else {
                            System.out.println(newNode.getValue());
                        }
                        break;
                    case 3:
                        newNode = findMin(rootNumber);
                        if (newNode == null) {
                            System.out.println("Cay khong ton tai");
                        } else {
                            System.out.println("Node co gia tri nho nhat tren cay la: " + (newNode.getValue()));
                        }
                        break;
                    case 4:
                        newNode = findMax(rootNumber);
                        if (newNode == null) {
                            System.out.println("Cay khong ton tai");
                        } else {
                            System.out.println("Node co gia tri lon nhat tren cay la: " + (newNode.getValue()));
                        }
                        break;
                    case 5:
                        System.out.println("Nhap NODE muon tim can truoc: ");
                        int a = scan.nextInt();
                        newNode = search(rootNumber, a);
                        newNode = predcessor(rootNumber, newNode);
                        if (newNode == null) {
                            System.out.println("Khong ton tai ke can truoc cua NODE");
                        } else{
                            System.out.println(newNode.getValue());
                        }
                        break;
                    case 6:
                        System.out.println("Nhap NODE muon tim can truoc: ");
                        int b = scan.nextInt();
                        newNode = search(rootNumber,b);
                        newNode = successor(rootNumber,newNode);
                        if (newNode == null){
                            System.out.println("Khong tim duoc ke can sau cua NODE");
                        }
                        else {
                            System.out.println(newNode.getValue());
                        }
                        break;
                    case 7:
                        System.out.println("Nhap vao gia tri cua Node muon xoa: ");
                        int x = scan.nextInt();
                        delNode(rootNumber,x);
                        break;
                    case 8:
                        displayTree(rootNumber);
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Nhap sai chuc nang, vui long nhap lai: ");
                        break;
                }
            }

        } else if ("N".equals(c) == true || "n".equals(c) == true) {    // lam viec voi chuoi


        } else {                              // Nhap sai
            System.out.println("Nhap sai, vui long chay lai chuong trinh! ");
        }

        scan.close();
    }


}
