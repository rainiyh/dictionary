import csv
WORD_ARRAY = []


class Node:
    def __init__(self, word,definition):
        self.left = None
        self.right = None
        self.word = word
        self.definitions = []
        self.definitions.append(definition)
    def addDefinition(self, definition):
        self.definitions.append(definition);


class Tree:
    def __init__(self):
        self.root = Node()

    def addWord(self, word, definition, node):
        if (word == node.word):
            node.addDefinition(definition)
            print(node.definitions[-1] + " definition was added to the word: " + node.word)
        elif(word > node.word):
            if (node.right != None):
                addWord(word, definition, node.right)
            else:
                node.right = Node(word, definition)
                print(node.word + " was added with the definition " + node.definitions[0])
        elif(word < node.word):
            if (node.left != None):
                addWord(word, definition, node.left)
            else:
                node.left = Node(word, definition)
                print(node.word + " was added with the definition " + node.definitions[0])

    def edit(self, word, definition, node):
        if(word == node.word):
            for defs in range(len(node.definitions)):
                node.definitions[defs] = None;
            node.addDefinition(definition)
            print("Definition for: " + node.word + " changed to: " + node.definitions)
        elif(word > node.word):
            if (node.right != word):
                edit(word, definition, node.right)
            else:
                for defs in range(len(node.definitions)):
                    node.definitions[defs] = None;
                node.addDefinition(definition)
                print("Definition for: " + node.word + " changed to: " + node.definitions)
        elif(word < node.word):
            if (node.left != word):
                edit(word, definition, node.left)
            else:
                for defs in range(len(node.definitions)):
                    node.definitions[defs] = None;
                node.addDefinition(definition)
                print("Definition for: " + node.word + " changed to: " + node.definitions)
    def deleteWord(self, word, definition, node):

    def searchWord(self, word, definition, node):
        if (word == node.word):
            print(node.word)
            for defs in node.definitions:
                print(defs)
        elif(word > node.word):
            if (node.right != word):
                searchWord(word, definition, node.right)
            else:
                print(node.word)
                for defs in node.definitions:
                    print(defs)
        elif(word < node.word):
            if (node.left != word):
                searchWord(word, definition, node.left)
            else:
                print(node.word)
                for defs in node.definitions:
                    print(defs)
def readIntoFile(filename):
    lineArray = []
    with open(filename, 'r') as f:
        reader = csv.reader(f)
        for ln in reader:
            print(ln[1])


readIntoFile("dictionary.csv")
