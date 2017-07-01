package src;

import java.util.TreeMap;

/**
 * Created by evenj on 2017/6/30.
 */
public class Tree<T> {
    public TreeNode t=new TreeNode();
    public Tree(T e){
        t.element=e;
    }
    private class TreeNode{
        T element;
        TreeNode nextSibling;
        TreeNode firstChild;
    }
    void addChild(TreeNode tt,T e){
        if(null!=tt.firstChild){
            addChild(tt.firstChild,e);
        }else {
            tt.firstChild=new TreeNode();
            tt.firstChild.element=e;
        }
    }
    void addSibling(TreeNode tt,T e){
        if(null!=tt.nextSibling){
            addSibling(tt.nextSibling,e);
        }else {
            tt.nextSibling=new TreeNode();
            tt.nextSibling.element=e;
        }
    }
    private void showAll(TreeNode tt){
        System.out.println(tt.element);
        if(null!=tt.firstChild){
            showAll(tt.firstChild);
        }
        if(null!=tt.nextSibling){
            showAll(tt.nextSibling);
        }
    }

    public static void main(String[] args) {
        Tree<String> tree=new Tree<>("1.0");
        tree.addChild(tree.t,"2.0");
        tree.addSibling(tree.t,"1.1");
        tree.addSibling(tree.t,"1.2");
        tree.addSibling(tree.t,"1.3");
        tree.showAll(tree.t);
        TreeMap t=new TreeMap();

    }

}
