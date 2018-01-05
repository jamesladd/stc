
| testMeta testClass testInstance |

Smalltalk import: 'st.redline.kernel.Object'.
Smalltalk import: 'st.redline.kernel.Class'.
Smalltalk import: 'st.redline.kernel.Metaclass'.

'====== Begin metaclass circularity' printString.

Smalltalk printString.
Smalltalk class printString.
Smalltalk class class printString.
Smalltalk class class class printString.
Smalltalk class class class class printString.
Smalltalk class class class class class printString.

'====== Begin superclass circularity' printString.
Object class superclass printString.

'====== Begin superclass' printString.
Smalltalk class superclass printString.
Smalltalk class superclass: Class.
Smalltalk class superclass printString.

'====== Begin Metaclass class>>subclassOf:' printString.
testMeta := Metaclass subclassOf: Class.
testMeta printString.
testMeta superclass printString.
testMeta class printString.

'====== Begin Metaclass class>>name:subclassOf:' printString.
testClass := Metaclass name: 'ATestClass' subclassOf: Object .
testClass printString.
testClass superclass printString.
testClass class printString.
testClass class superclass printString.

'====== Begin Class creation (subclass:)' printString.
Object subclass: #TestClassBootstrap.
TestClassBootstrap printString.

TestClassBootstrap atSelector: #test put: [
    ^'This is just a test' printString
].

testInstance := TestClassBootstrap basicNew.
testInstance printString.
testInstance class printString.
testInstance test.
