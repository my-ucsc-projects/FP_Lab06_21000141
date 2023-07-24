import scala.io.StdIn._
object Main {
  def main(args: Array[String]): Unit = {

    var str = readLine("Please enter a string to encryption or Decryption: ").toString
    var shift = readLine("Please enter the shift value: ").toInt

    def encrypt(str: String, sft: Int): String = {
      if(str.length==1){
        ((str(0) + shift).toChar).toString
      }
      else {
        ((str(0) + shift).toChar + encrypt(str.tail, sft))
      }
    }

    def decrypt(str: String, sft: Int): String = {
      if (str.length == 1) {
        ((str(0) - shift).toChar).toString
      }
      else {
        ((str(0) - shift).toChar + decrypt(str.tail, sft))
      }
    }

    def choose():String={
      var option = readLine("Enter what you want (Encryption/Decryption)").toLowerCase;
      if(option=="encryption"){
        encrypt(str,shift)
      }
      else if(option=="decryption"){
        decrypt(str,shift)
      }
      else {
        "Wrong Input"
      }
    }

    println(choose())
  }
}