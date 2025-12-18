

// @Component is the generic annotation for any Spring-managed component.
// Use this when the class doesn't fit into a specific layer like Service or Repository.
@Component
public class ComponentX
{
    public void doWork() {
        System.out.println("SimpleComponent is working...");
    }
}