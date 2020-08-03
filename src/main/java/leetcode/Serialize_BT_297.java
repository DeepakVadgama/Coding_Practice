public class Codec {

  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    marshall(root, sb);
    return sb.toString();      
  }

  private void marshall(TreeNode node, StringBuilder sb){
    if(node == null){
      sb.append("X,");
    } else {
      sb.append(node.val).append(",");
      marshall(node.left, sb);
      marshall(node.right, sb);
    }
  }

  public TreeNode deserialize(String data) {
    String[] values = data.split(",");
    Deque<String> queue = new ArrayDeque<>();
      queue.addAll(Arrays.asList(values));
      TreeNode root = unmarshall(queue);
      return root;      
  }

  private TreeNode unmarshall(Deque<String> values){
    String val = values.pop();
    if (val.equals("X")){
      return null;
    }
    TreeNode node = new TreeNode(Integer.valueOf(val));
    node.left = unmarshall(values);
    node.right = unmarshall(values);
    return node;
  }


}
