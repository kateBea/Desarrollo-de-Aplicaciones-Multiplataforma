string userInput = LeerCadena("Introduce tu nombre: ");
Console.WriteLine($"Buenos días {userInput}");

string? LeerCadena(string prompt) 
{
    Console.Out.WriteLine($"{prompt}");
    return  Console.ReadLine();
}