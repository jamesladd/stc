
Smalltalk import: 'st.redline.kernel.ClassDescription'.
Smalltalk import: 'st.redline.kernel.Metaclass'.

ClassDescription subclass: #Class.

- subclass: className
    "The actual definition of the subclass: method after the bootstrap is complete.
     Does not currently support variable definitions as they are not yet present."
    | newClass |
    newClass := Metaclass name: className subclassOf: self.
    Smalltalk at: className put: newClass.
    ^newClass
