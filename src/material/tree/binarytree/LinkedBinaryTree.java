
package material.tree.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import material.Position;

/**
 *
 * @author mayte
 * @param <T>
 */
public class LinkedBinaryTree<T> implements BinaryTree<T> {

    private BTNode<T> checkPosition(Position<T> v) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (v == null || !(v instanceof BTNode))
            throw new RuntimeException("This is an invalid position");
        return (BTNode<T>) v;
    }

    private LinkedBinaryTree<T> checkTree(BinaryTree<T> t1) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (t1 == null || !(t1 instanceof LinkedBinaryTree))
            throw new RuntimeException("This is an invalid BinaryTree");
        return (LinkedBinaryTree<T>) t1;
    }
    
    private class BTNode<E> implements Position<E>{
        
        private E elem;
        private BTNode<E> left;
        private BTNode<E> right;
        private BTNode<E> parent;

        public BTNode(E elem, BTNode<E> left, BTNode<E> right, BTNode<E> parent) {
            this.elem = elem;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public void setElem(E elem) {
            this.elem = elem;
        }

        public BTNode<E> getLeft() {
            return left;
        }

        public void setLeft(BTNode<E> left) {
            this.left = left;
        }

        public BTNode<E> getRight() {
            return right;
        }

        public void setRight(BTNode<E> right) {
            this.right = right;
        }

        public BTNode<E> getParent() {
            return parent;
        }

        public void setParent(BTNode<E> parent) {
            this.parent = parent;
        }
        
        @Override
        public E getElement() {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            return elem;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 61 * hash + this.elem.hashCode();
            hash = 61 * hash + this.left.hashCode();
            hash = 61 * hash + this.right.hashCode();
            hash = 61 * hash + this.parent.hashCode();
            return hash;
        }

        public boolean equals(BTNode<E> obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final BTNode<E> other = obj;
            if (!this.elem.equals(other.elem)) {
                return false;
            }
            if (this.left != other.left) {
                return false;
            }
            if (this.right != other.right)
                return false;
            
            return this.parent == other.parent;
        }
        
    }

    private BTNode<T> root;
    @Override
    public Position<T> left(Position<T> v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> p = checkPosition(v);
        return p.getLeft();
    }

    @Override
    public Position<T> right(Position<T> v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> p = checkPosition(v);
        return p.getRight();
    }

    @Override
    public boolean hasLeft(Position<T> v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> p = checkPosition(v);
        return (p.getLeft()!= null);
    }

    @Override
    public boolean hasRight(Position<T> v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> p = checkPosition(v);
        return (p.getRight() != null);
    }

    @Override
    public boolean isInternal(Position<T> v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (hasLeft(v) || hasRight(v));
    }

    @Override
    public boolean isLeaf(Position<T> p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return !isInternal(p);
    }

    @Override
    public boolean isRoot(Position<T> p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> v = checkPosition(p);
        return root == v;
    }

    @Override
    public Position<T> root() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return root;
    }

    @Override
    public T replace(Position<T> p, T e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> n = checkPosition(p);
        T element = n.getElement();
        n.setElem(e);
        return element;
    }

    @Override
    public Position<T> sibling(Position<T> p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isRoot(p))
            throw new RuntimeException("This position is the root");
        BTNode<T> n = checkPosition(p);
        if ( n == n.getParent().getLeft())
            return n.getParent().getRight();
        else
            return n.getParent().getLeft();
        
    }

    @Override
    public Position<T> addRoot(T e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (root != null)
            throw new RuntimeException("This tree already has a root");
        root = new BTNode<>(e,null,null,null);
        return root;
    }

    @Override
    public Position<T> insertLeft(Position<T> p, T e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> n = checkPosition(p);
        if (n.getLeft()!=null)
            throw new RuntimeException ("This position already has left child");
        BTNode<T> nuevo = new BTNode<>(e,null,null,n);
        n.setLeft(nuevo);
        return nuevo;
    }

    @Override
    public Position<T> insertRight(Position<T> p, T e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> n = checkPosition(p);
        if (n.getRight()!=null)
            throw new RuntimeException ("This position already has right child");
        BTNode<T> nuevo = new BTNode<>(e,null,null,n);
        n.setRight(nuevo);
        return nuevo;
    }

    @Override
    public T remove(Position<T> p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> n = checkPosition(p);
        if (isLeaf(p)){
            if (isRoot(p))
                root = null;
            else{
                if (n == n.getParent().getLeft()) //Hijo izquierdo
                    n.getParent().setLeft(null);
                else //Hijo derecho
                    n.getParent().setRight(null);
            }
        }
        else{
            if (hasLeft(p) && hasRight(p))
                    throw new RuntimeException("This position has two children");
            else{
                if (hasLeft(p)){
                    n.getLeft().setParent(n.getParent());
                    if (isRoot(p)){
                        root = n.getLeft();
                    }
                    else if (n == n.getParent().getLeft())//el nodo que vas a borrar es el hijo izquierdo de su padre
                            n.getParent().setLeft(n.getLeft());
                         else                                //el nodo que vas a borrar es el hijo derecho de su padre
                            n.getParent().setRight(n.getLeft());
                }
                else{//tiene hijo derecho
                    n.getRight().setParent(n.getParent());
                    if (isRoot(p)){
                        root = n.getRight();
                    }
                    else if (n == n.getParent().getLeft())//el nodo que vas a borrar es el hijo izquierdo de su padre
                            n.getParent().setLeft(n.getRight());
                         else                                //el nodo que vas a borrar es el hijo derecho de su padre
                            n.getParent().setRight(n.getRight());
                    }
                    
                }
        
            
        }
        return n.getElement();
        
    }

    @Override
    public void swap(Position<T> p1, Position<T> p2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> n1 = checkPosition(p1);
        BTNode<T> n2 = checkPosition(p2);
        T aux = n1.getElement();
        n1.setElem(n2.getElement());
        n2.setElem(aux);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Position<T> parent(Position<T> v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> n = checkPosition(v);
        if (root == n)
            throw new RuntimeException("This position is root");
        return n.getParent();
    }

    @Override
    public Iterable<? extends Position<T>> children(Position<T> v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> n = checkPosition(v);
        LinkedList<Position<T>> l = new LinkedList<>();
        if (n.getLeft()!= null)
            l.add(n.getLeft());
        if (n.getRight() != null){
            l.add(n.getRight());
        }
        return l;
    }

    @Override
    public Iterator<Position<T>> iterator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new InorderBinaryTreeIterator<>(this);
    }

    @Override
    public void attachLeft(Position<T> h, BinaryTree<T> t1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> n = checkPosition(h);
        LinkedBinaryTree<T> t = checkTree(t1);
        if (hasLeft(h))
            throw new RuntimeException("This position already has left child");
        n.setLeft(t.root);
        if (t.root != null)
            t.root.setParent(n);
        t.root = null;
    }

    @Override
    public void attachRight(Position<T> h, BinaryTree<T> t1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BTNode<T> n = checkPosition(h);
        LinkedBinaryTree<T> t = checkTree(t1);
        if (hasRight(h))
            throw new RuntimeException("This position already has right child");
        n.setRight(t.root);
        if (t.root != null)
            t.root.setParent(n);
        t.root = null;
    }

    @Override
    public BinaryTree<T> subTree(Position<T> h) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       BTNode<T> n = checkPosition(h);
       LinkedBinaryTree<T> t = new LinkedBinaryTree<>();
       t.root = n;
       n.parent = null;
       if (isRoot(h))
           this.root = null;
       return t;
    }
    
}
