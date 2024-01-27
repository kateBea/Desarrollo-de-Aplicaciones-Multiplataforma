using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scrEnemigo : MonoBehaviour
{
    
    public float speed = 7f;
    public GameObject lava;


    private void Start()
    {
        lava.SetActive(false);
    }

    private void OnCollisionStay(Collision collision)
    {
        if ((collision.gameObject.tag == "Muro") || (collision.gameObject.tag == "Enemigo"))
        {
            
            this.GetComponent<Transform>().Rotate(0f, Random.Range(0f, 350f), 0f, Space.Self);
            
        }
            
    }

    private void OnCollisionEnter(Collision collision)
    {
        if ((collision.gameObject.tag == "Muro") ||(collision.gameObject.tag == "Enemigo"))
            this.GetComponent<Transform>().Rotate(0f, Random.Range(0f, 350f), 0f, Space.World);

        if (collision.gameObject.tag == "Player")
        {
            lava.SetActive(true);
            Destroy(collision.gameObject);
        }
            
    }

    // Update is called once per frame
    void Update()
    {
            this.GetComponent<Rigidbody>().AddForce(transform.forward * speed, ForceMode.Impulse);
            
       
        
    }
}
