import book
import publisher
import member

def main():
    pubs = [
        Publisher('123', 'ABCD', 'Tesla'),
        Publisher('385', 'BFHG', 'Arcor'),
        Publisher('462', 'OTJH', 'Circus'),
        Publisher('782', 'MFNA', 'Gamer'),
        Publisher('999', 'KGSA', 'Unknown'),
        Publisher('692', 'QPRT', 'Comp'),
        Publisher('961', 'KLAN', 'Cresla'),
    ]

    for my_pubs in pubs:
        print(my_pubs)




main()