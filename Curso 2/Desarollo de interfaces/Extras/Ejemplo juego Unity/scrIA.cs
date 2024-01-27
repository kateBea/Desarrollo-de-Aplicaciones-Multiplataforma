using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class scrIA : MonoBehaviour
{
    [Header("Propiedades")]
    public NavMeshAgent agente;
    [Range(0,10)]
    public float velocidad;
    [Range(100, 500)]
    public float tiempo;
    public GameObject Objetivo;
    [Range(0, 5)]
    public float distancia;
    private float y;
    public bool localizado;

    

    // Start is called before the first frame update
    void Start()
    {
        localizado = false;
        
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        tiempo += 1;
        transform.Translate(transform.forward * velocidad * Time.fixedDeltaTime);
        if (tiempo >= Random.Range(100, 1000))
        {
            y = Random.Range(40, -40);
            tiempo = 0.0f;
        }
        else
        {
            y = 0;
        }
        transform.Rotate(new Vector3(0, y, 0));

        if ((Vector3.Distance(Objetivo.transform.position, transform.position) < distancia))
        {
            Debug.Log("A por el");
            agente.SetDestination(Objetivo.transform.position);
        }
        else
        {
            Debug.Log("Le Perdí");
        }
        
       
    }
}
