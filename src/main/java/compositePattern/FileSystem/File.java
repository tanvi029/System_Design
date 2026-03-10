package compositePattern.FileSystem;

public class File implements FileSystemComponent {
    String fileName;
    public File(String name) {
        this.fileName = name;
    }
    @Override
    public void printContents() {
System.out.println("File name: "+fileName);
    }
}
