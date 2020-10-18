import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 61404
 */
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Object hello = new HelloClassLoader().findClass("Hello").newInstance();
            Class<?> aClass = hello.getClass();
            Method setMethod = aClass.getDeclaredMethod("hello");
            setMethod.invoke(aClass.newInstance());

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("Hello.xlass");
        if (!f.exists()) {
            System.out.println("文件不存在！");
            return super.findClass(name);
        }

        FileChannel channel = null;
        FileInputStream fs = null;
        ByteBuffer ret = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer tmp = ByteBuffer.allocate((int) channel.size());
            ret = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(tmp)) > 0) {
                 System.out.println("reading");
            }

            for (int i=0; i<tmp.array().length; i++) {
                ret.put((byte) (255 - tmp.get(i)));
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (channel != null) {
                    channel.close();
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            try {
                if (fs != null) {
                    fs.close();
                }
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        return defineClass(name, ret.array(), 0, ret.array().length);
    }
}
