package tree.threadedbinarytree;

/**
 * 前中后序线索化二叉树及其遍历
 *
 * @author whoo
 * @create 2022-05-14 14:05
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        //测试中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "Tom");
        HeroNode node2 = new HeroNode(3, "Trump");
        HeroNode node3 = new HeroNode(6, "Biden");
        HeroNode node4 = new HeroNode(8, "Obama");
        HeroNode node5 = new HeroNode(10, "Dick");
        HeroNode node6 = new HeroNode(14, "Rose");
        HeroNode node7 = new HeroNode(22, "Rose");

        //先手动创建二叉树，后面要递归创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
//        threadedBinaryTree.threadedNodes();

        //测试前序线索化
//        threadedBinaryTree.preThreadedNodes();

        //测试后续线索化
        threadedBinaryTree.postThreadedNodes();

        //测试，以10号节点为测试条件
        HeroNode leftNode = node3.getLeft();//
        HeroNode leftNode1 = node5.getLeft();//
        HeroNode leftNode2 = node6.getLeft();//
        HeroNode leftNode3 = root.getLeft();//
        HeroNode rightNode = node3.getRight();//
        HeroNode rightNode1 = node5.getRight();//
        HeroNode rightNode2 = node6.getRight();//
        HeroNode rightNode3 = root.getRight();//
        System.out.println("6号节点的前驱节点：" + leftNode + "，后继节点：" + rightNode);
        System.out.println("10号节点的前驱节点：" + leftNode1 + "，后继节点：" + rightNode1);
        System.out.println("14号节点的前驱节点：" + leftNode2 + "，后继节点：" + rightNode2);
        System.out.println("1号节点的前驱节点：" + leftNode3 + "，后继节点：" + rightNode3);

        //当线索化二叉树后，不能再使用原来的方式遍历
//        threadedBinaryTree.infixOrder();//死循环
//        System.out.println("使用线索化的方式遍历线索化二叉树：");
        /*测试中序遍历*/
//        threadedBinaryTree.threadedList();
        /*测试前序遍历*/
//        threadedBinaryTree.preThreadedList();
        /*测试后序遍历*/
        threadedBinaryTree.postThreadedList();
    }
}

//定义ThreadedBinaryTree 实现了线索化功能的二叉树
class ThreadedBinaryTree {

    private HeroNode root;
    /*为了实现线索化，需要创建一个指向当前节点的前驱节点的指针
     * 在递归进行线索化时，pre总是保留前一个节点(单向的)*/
    private HeroNode pre = null;//只有pre才有可能实现线索化

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 遍历线索化二叉树的方法，中序遍历
     * 根据leftType和rightType的指引来遍历
     * 线索化后的数值leftType和rightType均为1
     */
    public void threadedList() {
        //定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环的找到leftType = 1的节点，第一个找到的是8节点
            //后面随着遍历而变化，因为当leftType = 1时说明该节点按照线索化
            //处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前节点
            System.out.println(node);

            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            /*退出循环，说明当前节点的右指针指向的不是后继节点，因此需要继续替换节点
              替换这个遍历的节点，不替换则出现死循环（指针移动到下一个节点）*/
            node = node.getRight();
        }
    }

    /**
     * 遍历线索化二叉树的方法，前序遍历（课后练习）
     * 根据leftType和rightType的指引来遍历
     * 线索化后的数值leftType和rightType均为1
     */
    public void preThreadedList() {
        //定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;

        while (node != null) {
            //因为是前序遍历，开头的数值的leftType肯定都是0，因此需要先打印出
            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }
            //打印出第一个leftType不为0的节点（当前节点）
            System.out.println(node);

            //如果当前节点的右指针指向后继节点，就一直输出
            while (node.getRightType() == 1) {
                //获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }

            //指针移动，防止死循环
            /*其实对于前序遍历的移动轨迹，
              上面的while循环结束就相当于走到最后一个节点了，
              下面这行代码起到退出外层while循环的作用*/
            node = node.getRight();
        }
    }

    /**
     * 遍历线索化二叉树的方法，后续遍历（课后练习）
     * 根据leftType和rightType的指引来遍历
     * 线索化后的数值leftType和rightType均为1
     * 因为后序遍历的根节点比较特殊，需要单独输出
     */
    public void postThreadedList() {

        //定义一个变量，存储当前遍历的节点，从root开始
        HeroNode node = root;

        while (node != null) {
            //因为是后序遍历，找到第一个leftType=1的节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印出第一个leftType不为0的节点（当前节点）
            System.out.println(node);

            //如果当前节点的右指针指向后继节点，就一直输出
            while (node.getRightType() == 1) {
                //获取当前节点的后继节点
                node = node.getRight();
                if(node == root){
                    break;
                }
                System.out.println(node);
            }
            //指针移动，移动至辅助指针位置，而不是单纯移动到右子节点
            node = node.getParent();
        }
        System.out.println(root);
    }

    /**
     * 重载线索化方法
     */
    public void threadedNodes() {
        threadedNodes(root);
    }

    /**
     * 编写对二叉树进行中序线索化的方法
     *
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node) {

        //如果node == null，不能线索化
        if (node == null) {
            return;
        }

        /*按照中序线索化的方式处理*/
        //1.先线索化左子树
        threadedNodes(node.getLeft());

        //2.线索化当前节点[有点难度]
        /*先处理当前节点的前驱节点
         * 以8节点理解：
         * 8节点的left = null，8节点的leftType = 1*/
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针的类型，指向前驱节点
            node.setLeftType(1);
        }
        /*处理后继节点
         * 因为是单向的，所以不能同时处理前驱后继节点。
         * 处理后继节点需要放在处理前驱节点结束，指针挪到下一个节点以后，
         * 这时候pre指针挪到原来节点的位置，通过pre指针安排后继节点*/
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }

        /*重要！！！每处理一个节点后，让当前节点成为下一个节点的前驱节点
         * 不写线索化会断掉*/
        pre = node;

        //3.再线索化右子树
        threadedNodes(node.getRight());
    }

    /**
     * 重写对二叉树进行前序线索化的方法
     */
    public void preThreadedNodes() {
        preThreadedNodes(root);
    }

    /**
     * 编写对二叉树进行前序线索化的方法（课后练习）
     *
     * @param node 当前需要线索化的节点
     */
    public void preThreadedNodes(HeroNode node) {

        //如果node == null，不能线索化
        if (node == null) {
            return;
        }

        //前序线索化
        //1.先线索化当前节点
        /*首先考虑一种特殊情况，当 当前节点只存在一个子节点且该子节点为左子节点的情况
         * 这里将左子节点转为右子节点，方便查询前序遍历的前驱节点和后继节点
         * 如果不做优化，就会有问题（比如题目中的节点6不做优化前驱节点和后继节点均为14）*/
        if (node.getLeft() != null && node.getRight() == null) {
            node.setRight(node.getLeft());
            node.setLeft(null);
        }
        //1.1.线索化当前节点的左子节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //1.2.线索化右子节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //移动
        pre = node;

        //2.线索化左子树
        if (node.getLeftType() == 0) {//举例：节点8获得了左子节点，为了防止无限循环需要加入判断条件
            preThreadedNodes(node.getLeft());
        }

        //3.线索化右子树
        if (node.getRightType() == 0) {
            preThreadedNodes(node.getRight());
        }
    }

    /**
     * 重写对二叉树进行后序线索化的方法
     */
    public void postThreadedNodes() {
        postThreadedNodes(root);
    }

    /**
     * 编写对二叉树进行后序线索化的方法（课后练习）
     * 后续线索化需要添加辅助变量，让存在左右子节点的节点指向后继节点，否则会遍历不成功
     *
     * @param node 当前需要线索化的节点
     */
    public void postThreadedNodes(HeroNode node) {

        //节点为空，无法进行线索化
        if (node == null) {
            return;
        }

        //后序线索化
        //1.首先对左子树进行线索化
        postThreadedNodes(node.getLeft());

        //2.再对右子树进行线索化
        postThreadedNodes(node.getRight());

        //3.对当前节点进行线索化
        //线索化左子节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
            //跳转专用，前提是该节点不为空且左右子节点均存在
            if (pre != null && pre.getRight() != null && pre.getLeft() != null) {
                pre.setParent(node);
            }
        }
        //线索化右子节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);

        }
        pre = node;
    }

}

//创建HeroNode
class HeroNode {

    private int no;
    private String name;
    private HeroNode left;//默认null
    private HeroNode right;//默认null
    private HeroNode parent;//为后序遍历使用，作为左右子节点已满的节点的第三个辅助节点

    public HeroNode getParent() {
        return parent;
    }

    public void setParent(HeroNode parent) {
        this.parent = parent;
    }

    /*改造：当线索化二叉树后，Node 节点的 属性 left 和 right有两种情况，因此需要标记
     * 说明：
     * 1.如果leftType == 0 表示指向的是左子树，如果1表示指向前驱节点
     * 2.如果rightType == 0 表示指向右子树，如果1表示指向后继节点*/
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' + "}";
    }

}