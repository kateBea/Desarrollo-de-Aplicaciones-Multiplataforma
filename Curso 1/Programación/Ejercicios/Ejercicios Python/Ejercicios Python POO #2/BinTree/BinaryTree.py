class BinTree:
    def __init__(self, data = None, leftSubTree = None, rightSubTree = None):
        self._data = data
        self._left = leftSubTree
        self._right = rightSubTree

    @property
    def data(self):
        return self._data
    
    @property
    def left(self):
        return self._left
    
    @property
    def right(self):
        return self._right
    
    
    def recorrido_preorden(self):
        if self._data != None:
            print(self._data)

        if self._left != None:
            self._left.recorrido_preorden()

        if self._left != None:
            self._right.recorrido_preorden()

        
        
