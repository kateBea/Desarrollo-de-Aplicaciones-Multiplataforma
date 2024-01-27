using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scrRadar : MonoBehaviour
{
    [Header("Objeto del que sale el rayo")]
    public Transform rcRadar;

    [Header("Variable para marcar la distancia")]
    [Range(1,10)]
    public float largo;

    [Header("Punto de Mira")]
    public GameObject pnlMira;

    private GameObject objeto;

    private void Start()
    {
        pnlMira.SetActive(false);
    }


    void Update()
    {
        Debug.DrawRay(rcRadar.position, rcRadar.forward * largo, Color.green);
        RaycastHit contacto;
        if (Physics.Raycast(rcRadar.position, rcRadar.forward, out contacto, largo, LayerMask.GetMask("Enemigos")))
        {
            pnlMira.SetActive(true);
            StartCoroutine(destruir(contacto.transform.gameObject));     
        }else{
            pnlMira.SetActive(false);
        }
        
    }

    IEnumerator destruir(GameObject obj)
    {
        yield return new WaitForSeconds(.2f);
        Destroy(obj);
    }
}
