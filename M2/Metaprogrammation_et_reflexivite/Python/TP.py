import inspect
import unittest


# Memo metaclass
class MemoClass(type):
    instances = [] # List of instances

    def __call__(cls, *args, **kwargs):
        instance = super(MemoClass, cls).__call__(*args, **kwargs)
        MemoClass.instances.append(instance)
        return instance


# Implementation of a stack
class Stack(object, metaclass = MemoClass):
    def __init__(self, capacity = 5):
        self.capacity = capacity            # Size of the stack, 5 if no value given by the user
        self.content = [None] * capacity    # We store the content in a list
        self.index = 0                      # Index for the next element

    def isEmpty(self):
        return (self.index == 0)

    def isFull(self):
        return (self.index == self.capacity)

    # Adds an element at the top of the stack
    # Returns the entire stack if everything went correctly
    def push(self, newObject):
        if self.isFull():
            raise Exception("Stack is full")
        else:
            self.content[self.index] = newObject
            self.index += 1

        return self

    # Removes the element at the top of the stack
    # Returns the element removed if everything went correctly
    def pop(self):
        if self.isEmpty():
            raise Exception("Stack is empty")
        else:
            top = self.top()
            del self.content[self.index - 1]
            self.index -= 1

        return top

    # Returns the element at the top of the stack
    def top(self):
        result = None

        if self.isEmpty():
            raise Exception("Stack is empty")
        else:
            result = self.content[self.index - 1]

        return result

    # Doubles the capacity
    # Returns the entire stack if everything went correctly
    def grow(self):
        oldCapacity = self.capacity
        oldcontent = self.content

        self.capacity = self.capacity * 2
        self.content = [None] * self.capacity
        self.index = 0

        for i in range(0, oldCapacity):
            self.push(oldcontent[i])

        return self

    # Returns a string describing the object
    def __str__(self):
        return "A stack of capacity " + str(self.capacity) + " with " + str(self.index) + " objects stored: " + str(self.content)


# Unit tests for the stack class
class TestStack(unittest.TestCase):
    emptyStack = Stack()
    fullStack = Stack().push(0).push(1).push(2).push(3).push(4)

    def test_isEmpty(self):
        self.assertTrue(self.emptyStack.isEmpty())
        self.assertFalse(self.fullStack.isEmpty())

    def test_isFull(self):
        self.assertFalse(self.emptyStack.isFull())
        self.assertTrue(self.fullStack.isFull())

    def test_push(self):
        self.assertEqual(self.emptyStack.push(5), self.emptyStack)
        self.assertRaises(Exception, self.fullStack.push, 5)

    def test_pop(self):
        self.assertRaises(Exception, self.emptyStack.pop)
        top = self.fullStack.top()
        self.assertEqual(self.fullStack.pop(), top)


# Inspects a chosen class and prints its attributes (name and value)
class Inspector(object):
    @staticmethod
    def inspect(inspectedObject):
        print("Inspecting attributes:")
        for attribute in inspectedObject.__dict__:
            print(str(attribute) + ": " + str(inspectedObject.__dict__[attribute]))
        


# Metaclass used for the class Room
class CapacityClass(type):
    maxInstances = 2
    instanceCount = 0

    def __call__(cls, *args, **kwargs):
        if CapacityClass.instanceCount < CapacityClass.maxInstances:
            CapacityClass.instanceCount += 1
            print("Instance", CapacityClass.instanceCount, " of CapacityClass created.", (CapacityClass.maxInstances - CapacityClass.instanceCount), "left.")
            return super(CapacityClass, cls).__call__(*args, **kwargs)
        else:
            raise Exception("Max capacity reached.")


# Classroom
class Room(object, metaclass = CapacityClass):
    pass


# Abstract metaclass
class AbstractClass(type):
    def __call__(cls, *args, **kwargs):
        if cls == Animal:
            raise Exception("Cannot instanciate an abstract class (" + str(cls) + ").")
        else:
            return super(AbstractClass, cls).__call__(*args, **kwargs)


# Animal classes
class Animal(object, metaclass = AbstractClass):
    pass


class Cat(Animal):
    pass


class Dog(Animal):
    pass


# Main method
if __name__ == '__main__':
    # Inspection of a stack object
    stack = Stack().push(3).push(5)
    Inspector.inspect(stack)

    # Checking that the memoclass remembers its instances
    for instance in MemoClass.instances:
        print(instance)

    Room()
    Room()
    #Room() # Trying to instanciante a room once more will raise an exception

    #Animal() # Trying to instanciate an animal will raise an exception
    Cat()
    Dog()

    unittest.main() # We call this method to start the tests on the stack class
