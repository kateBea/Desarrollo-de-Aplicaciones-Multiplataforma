const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

function readUntilString(targetString) {
  rl.question(`Enter something (type '${targetString}' to stop): `, (userInput) => {
    if (userInput === targetString) {
      rl.close();
    } else {
      console.log(`You entered: ${userInput}`);
      readUntilString(targetString);
    }
  });
}

const targetString = 'exit';
readUntilString(targetString);

rl.on('close', () => {
  console.log('Program stopped.');
});
