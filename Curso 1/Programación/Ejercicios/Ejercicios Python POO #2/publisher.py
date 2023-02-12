class Publisher:
    def __int__(self, pub_id, address, name):
        self._pub_id = pub_id
        self._address = address
        self._name = name

    def __str__(self):
        return f'Id: {self._pub_id} Address: {self._address} Name: {self._name}'

    def get_name(self):
        return self._name

    def get_id(self):
        return self._pub_id

    def get_address(self):
        return self._address