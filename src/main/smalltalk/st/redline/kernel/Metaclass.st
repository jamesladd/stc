
Smalltalk import: 'st.redline.kernel.ClassDescription'.

ClassDescription subclass: #Metaclass.

- basicNew
    "primitive 70"
    "Instances of (instances of) Metaclass are (still) PrimClass objects, not just PrimObject."
    JVM typeInsn: #NEW
        type: 'st/redline/kernel/PrimClass' .
    JVM insn: #DUP .
    JVM ldcInsn: 'instance of a Metaclass'.
    JVM ldcInsn: false.
    JVM methodInsn: #INVOKESPECIAL
        owner: 'st/redline/kernel/PrimClass'
        name: '<init>'
        descr: '(Ljava/lang/String;Z)V'
        iface: false .
    JVM varInsn: #ASTORE
        index: 3.
    JVM varInsn: #ALOAD
        index:  3 .
    JVM loadVar: self. "add the receiver to the stack"
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'clazz'
        descr: '(Lst/redline/kernel/PrimObject;)V'
        iface: false .
    JVM varInsn: #ALOAD
        index:  3 .

+ basicNew
    "primitive 70"
    "Instances of Metaclass are PrimClass objects, not just PrimObject."
    JVM typeInsn: #NEW
        type: 'st/redline/kernel/PrimClass' .
    JVM insn: #DUP .
    JVM ldcInsn: 'a Metaclass'.
    JVM ldcInsn: true.
    JVM methodInsn: #INVOKESPECIAL
        owner: 'st/redline/kernel/PrimClass'
        name: '<init>'
        descr: '(Ljava/lang/String;Z)V'
        iface: false .
    JVM varInsn: #ASTORE
        index: 3.
    JVM varInsn: #ALOAD
        index:  3 .
    JVM loadVar: self. "add the receiver to the stack"
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'clazz'
        descr: '(Lst/redline/kernel/PrimObject;)V'
        iface: false .
    JVM varInsn: #ALOAD
        index:  3 .

+ subclassOf: superMeta
    "Answer an instance of Metaclass that is a subclass of the metaclass @superMeta."
    | subMeta |
    subMeta := self basicNew.
    subMeta superclass: superMeta.
    ^ subMeta .

+ name: newName subclassOf: superClass
    "Creates a new metaclass and its sole instance, answers the sole instance.
     Based on the method in the Metaclass class protocol in the Blue Book but ignoring
     most of the keywords such as environment:, instanceVariableNames:, etc., as they
     are yet to be handled and this may not be how classes are created in the end."
    | meta superClassClass subClass |
    "the following line does not currently work as the compiler does not appear to apply
     the correct precedence to the final unary message send."
    "meta := self subclassOf: superClass class."
    superClassClass := superClass class.
    meta := self subclassOf: superClassClass.
    JVM loadVar: meta.
    JVM loadVar: newName.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'javaValue'
        descr: '()Ljava/lang/Object;'
        iface: false.
    JVM varInsn: #ASTORE
        index: 3.
    JVM varInsn: #ALOAD
        index: 3.
    JVM typeInsn: #CHECKCAST
        type: 'java/lang/String'.
    JVM ldcInsn: '(meta)'.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'java/lang/String'
        name:  'concat'
        descr: '(Ljava/lang/String;)Ljava/lang/String;'
        iface: false.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'javaValue'
        descr: '(Ljava/lang/Object;)V'
        iface: false.
    subClass := meta basicNew.
    subClass superclass: superClass.
    JVM loadVar: subClass.
    JVM varInsn: #ALOAD
        index: 3.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'javaValue'
        descr: '(Ljava/lang/Object;)V'
        iface: false.
    ^subClass .
