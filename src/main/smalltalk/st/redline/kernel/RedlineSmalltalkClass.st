
"This is just for bootstrapping."
PrimObject subclass: #RedlineSmalltalkClass.

- at: className put: aClass
    "Effectively a primitive to make it easier to register classes from the Smalltalk side."
    "XXX: Technically the Smalltalk pool is a dictionary, so this should be inherited from 
     Dictionary when the bootstrap is fully complete??"
    JVM loadVar: className.
    JVM methodInsn: #INVOKEVIRTUAL
        owner: 'st/redline/kernel/PrimObject'
        name:  'javaValue'
        descr: '()Ljava/lang/Object;'
        iface: false.
    JVM varInsn: #ASTORE
        index: 3.
    JVM loadVar: self.
    JVM loadVar: aClass.
    JVM varInsn: #ALOAD
        index: 3.
    JVM typeInsn: #CHECKCAST
        type: 'java/lang/String'.
    JVM methodInsn: #INVOKEINTERFACE
        owner: 'st/redline/Smalltalk'
        name:  'register'
        descr: '(Lst/redline/kernel/PrimObject;Ljava/lang/String;)Lst/redline/Smalltalk;'
        iface: true.
    ^self
