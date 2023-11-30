var nodemailer = require('nodemailer');

const transporter = nodemailer.createTransport({
    host: 'smtp01.educa.madrid.org',
    port: 587,
    auth: {
        user: 'your-mail@domain.com',
        pass: 'your-pasword'
    }

});

const mailOptions = {
    from: 'your-mail@domain.com',
    to: 'receiver-mail@domain.com',
    subject: 'Hola Mundo',
    html: 'Esto esta contenido'
};

transporter.sendMail(mailOptions, (error, info) => {
    if (error) {
        console.log(error);
        return;
    }

    console.log("Message sent:" + info.messageId);
});