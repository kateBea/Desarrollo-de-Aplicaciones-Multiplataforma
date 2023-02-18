class Publisher:
    def __int__(self, pub_id, address, name):
        self.pub_id = pub_id
        self.address = address
        self.name = name

    def __str__(self):
        return f'Id: {self.pub_id} Address: {self.address} Name: {self.name}'