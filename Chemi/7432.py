class Node:
    def __init__(self):
        self.children = {}

class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, path):
        current = self.root
        components = path.split("\\")
        for component in components:
            if component not in current.children:
                current.children[component] = Node()
            current = current.children[component]

    def print_sorted(self, node, depth):
        for name, child in sorted(node.children.items()):
            print(" " * depth + name)
            if child:
                self.print_sorted(child, depth + 1)

if __name__ == "__main__":
    n = int(input())
    trie = Trie()

    for _ in range(n):
        path = input().strip()
        trie.insert(path)
    
    trie.print_sorted(trie.root, 0)
