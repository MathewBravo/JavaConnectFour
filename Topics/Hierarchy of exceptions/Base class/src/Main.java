// update the class
class MyException extends java.lang.Throwable{
    MyException(String message){
        super(message);
    }

}

//do not change the code
class Main {
    public static void main(String[] args) {
        MyException myException = new MyException("This is a custom exception");
        System.out.println(myException.getMessage());
        Class<?> superClass = myException.getClass().getSuperclass();
        System.out.println(superClass.equals(Throwable.class));

        try {
            // code that may throw an exception
        } catch (IndexOutOfBoundsException e) {
            // ...
        } catch (RuntimeException e) {
            // ...
        } catch (Exception e) {
            // ...
        }
    }
}