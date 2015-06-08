package com.bezditnyi.homework.lesson8.vfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Viktor Bezditnyi.
 */
public class VirtualObject {
    private String name;
    private boolean isDirectory;
    private VirtualObject parent;
    private List<VirtualObject> children;

    public VirtualObject(String name, boolean isDirectory, VirtualObject parent) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.parent = parent;
        this.children = null;
    }

    public String getName() {
        return name;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public boolean isFile() {
        return !isDirectory;
    }

    public VirtualObject getParent() {
        return parent;
    }

    // first (root) VirtualObject has parent=null
    // get
    public String getParentName() {
        if (parent == null) {
            return "NullParentOfRoot";
        }
        return parent.getName();
    }

    public List<VirtualObject> getChildren() {
        return children;
    }

    /**
     * Returns array of children names. If object is childless it returns null.
     *
     * @return array of String or null
     */
    public String[] getChildrenNames() {
        if (children == null) {
            return null;
        }
        String[] childrenNames = new String[children.size()];
        int i = 0;
        for (VirtualObject child: children) {
            childrenNames[i++] = child.getName();
        }
        return childrenNames;
    }

    /**
     * Returns the child with name equals 'name' or null.
     *
     * @param name name of child to find
     * @return the child or null
     */
    public VirtualObject getChild(String name) {
        if (!this.isDirectory || name == null){
            // System.out.println("IsFile or NullName");
            return null;
        }
        if (this.children == null) {
            // System.out.println("Childless");
            return null;
        }
        VirtualObject childToFind = null;
        for(VirtualObject child: this.children) {
            if (child.getName().equals(name)) {
                childToFind = child;
                break;
            }
        }
        // Returns null if name not found
        return childToFind;
    }

    /**
     * Returns the child from given position. If pos out of range it returns null.
     *
     * @param pos position of the object to return
     * @return the child from given position or null
     */
    public VirtualObject getChild(int pos) {
        if (pos >=0 && pos < this.children.size()) {
            return this.children.get(pos);
        }
        return null;
    }

    /**
     * Returns the position of child with name.
     *
     * @param name name of child
     * @return the position
     */
    public int getChildPos(String name) {
        if (!this.isDirectory || name == null){
            return -1;
        }
        for (int i = 0; i < this.children.size(); i++) {
            if(children.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param pos position of the child
     * @return the name of the child on position
     */
    public String getChildName(int pos) {
        if (pos >=0 && pos < this.children.size()) {
            return this.children.get(pos).getName();
        }
        return null;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param name name of the object index of the element to return
     * @param isDirectory if true the object is directory
     * @return true if adding successful, null otherwise
     */
    public boolean add(String name, boolean isDirectory) {
        if (!this.isDirectory || name == null){
            return false;
        }
        if (this.children == null){
            this.children = new ArrayList<>();
        }
        for (VirtualObject child: this.children) {
            if (child.getName().equals(name)){
                return false;
            }
        }
        this.children.add(new VirtualObject(name, isDirectory, this));
        return true;
    }


    public boolean delete(String name) {
        if (!this.isDirectory || name == null){
            return false;
        }
        if (this.children == null) {
            return false;
        }
        VirtualObject childToDelete = null;
        for (VirtualObject child : this.children) {
            if (child.getName().equals(name)) {
                childToDelete = child;
                break;
            }
        }
        if (childToDelete != null) {
            if (!childToDelete.deleteAll()) {
                return false;
            }
            this.children.remove(childToDelete);
            if (this.children.isEmpty()) {
                this.children = null;
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean delete(VirtualObject child){
        if (!this.isDirectory){
            return false;
        }
        if (this.children == null) {
            return false;
        }
        if (this.children.contains(child)) {
            if (!child.deleteAll()) {
                return false;
            }
            this.children.remove(child);
            if (this.children.isEmpty()) {
                this.children = null;
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean deleteAll() {
        if (this.isDirectory) {
            if (this.children != null) {
                for (VirtualObject child : this.children) {
                    if (!child.deleteAll()) {
                        return false;
                    }
                }
                this.children.clear();
                this.children = null;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(name + "\n");
        if (this.isDirectory()) {
            res.insert(0, "\\");
            if (this.children != null) {
                for (VirtualObject child : this.children) {
                    res.append("  ");
                    if (child.isDirectory) {
                        res.append("\\");
                    }
                    res.append(child.getName());
                    res.append("\n");
                }
            }
        }
        return res.toString();
    }

    public String treeToString(String prefix) {
        StringBuilder res = new StringBuilder(prefix);
        if (isDirectory) {
            res.append("\\");
            res.append(name);
            res.append("\n");
            if (this.children != null) {
                for (VirtualObject child : children) {
                    res.append(child.treeToString("|" + prefix));
                }
            }
        } else {
            res.append(name);
            res.append("\n");
        }
        return res.toString();
    }
}
