#include <cstdio>

class btree {
    class node {
        int _data;
        node *_left;
        node *_right;

        public:
            node(int);

            int data() const { return _data; }
            node *left() { return _left; }
            node *left(node *l) { return _left = l; }
            node *right() { return _right; }
            node *right(node *l) { return _right = l; }
    };

    node *root;
    int n;
    int s;

    bool ins(node *, int);
    void inorder(node *);
    void preorder(node *);
    void postorder(node *);

    public:

        btree(int);

        int size() const { return s; }
        int cap() const { return n; }
        bool full() { return s == n; }
        bool empty() { return s == 0; }

        bool ins(int x) { return ins(root, x); }
        void inorder() { inorder(root); }
        void preorder() { preorder(root); }
        void postorder() { postorder(root); }
};

// constructor
btree::node::node(int x){
    _data = x;
    _left = NULL;
    _right = NULL;
}

btree::btree(int _n){
    root = NULL;
    n = _n;
    s = 0;
}

// Funcion interna
bool btree::ins(btree::node *p, int x){
    if(full()){
        printf("Arbol lleno \n");
        return false;
    }

    if(!root) {
        root = new node(x);
        s++;
        return true;
    }
    else {
        node *p = root;
        node *q = NULL;

        while(p && p->data() != x){
            q = p;
            p = x < p->data() ? p->left() : p->right();
        }

        if(!p) {
            // Hago la inserccion
            if(x < q->data()) q->left(new node(x));
            else q->right(new node(x));

            s++;

            return true;
        }
    }

    // no se hizo la inserccion
    return false;
}

void btree::inorder(btree::node *p){
    if(!p) return;

    inorder(p->left());
    printf("%4i", p->data());
    inorder(p->right());
}

void btree::preorder(btree::node *p){
    if(!p) return;

    printf("%4i", p->data());
    preorder(p->left());
    preorder(p->right());
}

void btree::postorder(btree::node *p){
    if(!p) return;

    postorder(p->left());
    postorder(p->right());
    printf("%4i", p->data());
}

int main()
{
    // Creamos un arbol
    btree t(20);

    // Insertamos los datos
    t.ins(10);
    t.ins(5);
    t.ins(15);
    t.ins(3);
    t.ins(9);
    t.ins(12);
    t.ins(18);
    t.ins(7);
    t.ins(11);
    t.ins(14);

    // Recorremos los arboles
    printf("Inorden: ");
    t.inorder();

    printf("\n\nPreorden: ");
    t.preorder();

    printf("\n\nPostorden: ");
    t.postorder();
    printf("\n\n");

    return 0;
}
